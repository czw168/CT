package cn.ubot.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.CollectionUtils;

import cn.ubot.config.DynamicDataSource;
import cn.ubot.mapper.SqliteMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Report3Test {

	static final String BASE_URL = "C:\\Users\\victor_chen\\Desktop\\SQlite\\Image";
	String firstFolderName = null;
	
	@Test
	public void t() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		SqliteMapper sqliteMapper = (SqliteMapper) applicationContext.getBean("sqliteMapper");
		
		// 重点： 实际操作证明，切换的时候最好清空一下
		DynamicDataSource.clearCustomerType();
		// 切换数据源，设置后 就OK了。可以随时切换过来（在controller层切换）
		DynamicDataSource.setCustomerType(DynamicDataSource.dataSourceMysqlSqlite);
		
		String table = "tbl_inspect_detail_59";
		List<Integer> actualNgIds = Arrays.asList(9490, 10734, 10749, 10973, 12047, 12786, 13064, 13862, 13961, 14362, 14470, 14506, 14946, 16031, 16032, 16068, 16069, 16090, 16165, 16167, 16169, 16174, 16175, 16176);
		Integer l = 3;
		
		// 获取A组的NG信息
		List<Map<String, Object>> catANgInfo = sqliteMapper.getCatANgInfo(table, actualNgIds, l);
		// 获取A组的NG信息
		List<Map<String, Object>> catBNgInfo = sqliteMapper.getCatBNgInfo(table, actualNgIds, l);
		// 获取A组的NG信息
		List<Map<String, Object>> catCNgInfo = sqliteMapper.getCatCNgInfo(table, actualNgIds, l);
		
		getPictureUrls(catANgInfo);
		System.out.println("=========================");
		getPictureUrls(catBNgInfo);
		System.out.println("=========================");
		getPictureUrls(catCNgInfo);
		
	}
	

	/**
	 * 	获取图片地址
	 * @param ngInfo：catA、catB、catC的ngInfo
	 */
	public List<String> getPictureUrls(List<Map<String, Object>> ngInfo) {

		// 存放图片url集合
		List<String> pictureUrls = new ArrayList<String>();
		
		for (int i = 0; i < ngInfo.size(); i++) {
			
			Map<String, Object> map = ngInfo.get(i);
			String date = (String) map.get("Date");
			String procCount = String.format("%010d", (int) map.get("ProcCount"));
			
			log.info("=======================================================================================");
			log.info("Date:" + date);
			log.info("procCount:" + procCount);
			
			// 格式转换,例:2020-09-09 11:35:46 转换成 20200909_113546
			String folderName = date.replace(" ", "_").replace("-", "").replace(":", "");
			log.info("folderName:" + folderName);
			firstFolderName = folderName;
			
			List<String> folders = getFolders(BASE_URL, folderName);
			// 本业务逻辑只会返回一个目录名
			String actualFolderName = folders.get(0);
			log.info("actualFolderName:" + actualFolderName);
			
			// 图片名(不含后缀)
			String pictureName = folderName + "_" + procCount + "_&Cam2Img";
			// 获取图片全名(含后缀)
			List<String> pictureNames = getPictures(BASE_URL + "\\" + actualFolderName, pictureName);
			// 本业务逻辑只会返回一张图片
			String actualPictureName = pictureNames.get(0);
			log.info("actualPictureName:" + actualPictureName);
			
			// C:\Users\victor_chen\Desktop\SQlite\Image\20200909_114506\20200909_114831_0000013000_&Cam2Img.Bmp
			
			// 拼接url
			String pictureUrl = BASE_URL + "\\" + actualFolderName + "\\" + actualPictureName;
			pictureUrls.add(pictureUrl);
			
		}
		
		for (String url : pictureUrls) {
			System.out.println(url);
		}
		
		return pictureUrls;
	}

	/**
	 * 	查看文件目录是否存在（精准查询）
	 */
	public boolean getFolder(String folderUrl) {
		File file = new File(folderUrl);
		if (file.exists()) {
			return true;
		} 
		return false;
	}
	
	/**
	 * 	获取真实的目录名（模糊查询）
	 */
	public List<String> getFolders(String url, String folderName) {
		
		String queryFolderName = folderName.substring(0, folderName.length() - 2);
		
		List<String> folderNames = new ArrayList<String>();
		
		File file = new File(url);
		File fa[] = file.listFiles();
		queryFolderName = queryFolderName == null ? "" : queryFolderName;
		for (int i = 0; i < fa.length; i++) {
			File fs = fa[i];
			if (fs.getName().indexOf(queryFolderName) != -1) {
				if (fs.isDirectory()) {
					folderNames.add(fs.getName());
				}
			}
		}
		
		// 如果没有这个目录则换一个目录继续找
		if(CollectionUtils.isEmpty(folderNames)) {
			folderName = newFolderName(folderName);
			folderNames = getFolders(url,folderName);
		}else {
			// 本业务只会出现一张图片
			String result = folderNames.get(0);
			String resultSuffix = result.substring(result.indexOf("_") + 1);
			String firstFolderNameNameSuffix = firstFolderName.substring(firstFolderName.indexOf("_") + 1);
			// 如果找到的目录名的后缀数字大于查找目录名的后缀数字,说明图片不是在这个目录,需要换一个目录继续找
			if(Long.parseLong(resultSuffix) > Long.parseLong(firstFolderNameNameSuffix)) {
				folderName = newFolderName(folderName);
				folderNames = getFolders(url,folderName);
			}
		}
		
		return folderNames;
		
	}
	
	/**
	 * 	获取图片名（包含后缀名）
	 */
	public List<String> getPictures(String url, String pictureName) {
		
		List<String> pictureNames = new ArrayList<String>();
		
		File file = new File(url);
		File fa[] = file.listFiles();
		pictureName = pictureName == null ? "" : pictureName;
		for (int i = 0; i < fa.length; i++) {
			File fs = fa[i];
			if (fs.getName().indexOf(pictureName) != -1) {
				if (!fs.isDirectory()) {
					pictureNames.add(fs.getName());
				}
			}
		}
		
		return pictureNames;
		
	}
	
	/**
	 * 	获取新的目录名（分钟数-1)
	 * 
	 * 	例：
	 * 	folderName：	20200909_110352
	 * 	prefix:		20200909_
	 * 	content:	1103
	 * 	suffix:		52
	 * 	hh:			11
	 * 	mm:			03
	 * 
	 * @param folderName
	 * @return
	 */
	public String newFolderName(String folderName) {
		// 前缀
		String prefix = folderName.substring(0, folderName.indexOf("_") + 1);
		log.info("prefix:" + prefix);
		// 主体内容
		String content = folderName.substring(folderName.indexOf("_") + 1, folderName.indexOf("_") + 5);
		log.info("content:" + content);
		// 后缀
		String suffix = folderName.substring(folderName.length() - 2);
		log.info("suffix:" + suffix);
		
		// 主体内容转换成【时：分】格式
		String hh = content.substring(0, 2);
		String mm = content.substring(2);

		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy");

		try {
			Date time1 = sdf.parse(hh + ":" + mm);
			Date time2 = sdf.parse("00:01");
			long l = time1.getTime() - time2.getTime() + sdf2.parse("1970").getTime();
			String result = sdf.format(new Date(l));
			// 再转回文件名返回
			result = result.replace(":", "");
			folderName = prefix + result + suffix;

		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		log.info("newFolderName:" + folderName);

		return folderName;
	}
	
	@Test
	public void get() {
		// System.out.println(newFolderName("20200909_110352"));
		// System.out.println(getFolders(BASE_URL, "20200909_110926"));
		// System.out.println(getPictures(BASE_URL + "\\20200909_114506","20200909_114803_0000012872_&Cam2Img"));
	}
	

	@Test
	public void tTime() {
		String content = "1644";
		
		// 主体内容转换成【时：分】格式
				String hh = "12";
				String mm = "44";
				
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy");
				//1644   0443
				try {
					Date time1 = sdf.parse(hh + ":" + mm);
					Date time2 = sdf.parse("00:01");
					long l = time1.getTime() - time2.getTime() + sdf2.parse("1970").getTime();
					String result = sdf.format(new Date(l));
					// 再转回文件名返回
					result = result.replace(":", "");
					//folderName = prefix + result + suffix;
					System.out.println(result);
				} catch (ParseException e) {
					e.printStackTrace();
				}
	}
	
//	@Test
//	public void tLinux() {
//		try {
//			//String path= "/home/";
//			String path= "/mnt/8TB/DATA/KEYENCE/CA-H1DB/192.168.0.10/VisionDB/CV-X470A_00_01_FC_27_03_6F/SD1/007/Image/20200705_063635";
//			File file=new File(path);
//			File[] tempList = file.listFiles();
//			for (int i = 0; i < tempList.length; i++) {
//			if (tempList[i].isFile()) {
//			//FileInputStream fis = new FileInputStream("fileName");
//			//InputStreamReader isr = new InputStreamReader(fis,"utf-8");
//			StringBuffer buffer = new StringBuffer();
//			String text;
//			BufferedReader input = new BufferedReader (new FileReader(tempList[i]));
//			while((text = input.readLine()) != null)
//			buffer.append(text +"/n"); }
//			if (tempList[i].isDirectory()) {
//			System.out.println("文件夹："+tempList[i]);
//			}
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
	@Test
	public void ttt() {
		System.out.println(System.getProperties().getProperty("os.name"));
	}
	
}
