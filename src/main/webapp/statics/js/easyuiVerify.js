/**
 * easyui自定义表单校验
 */
$.extend($.fn.validatebox.defaults.rules, {
	// 只能输入数字、小数点
	double_ : {
		validator: function (value) {
			return /^\d+(\.\d+)?$/.test(value);
		},
		message: 'Please enter a valid number'
	},
	// 只能输入大写字母、数字
	majusculeAndNumber : {
		validator: function (value) {
			// 字母小写转换成大写
			this.value = this.value.toUpperCase();
			return /^[A-Z0-9]*$/.test(value);
		},
		message: 'Format error'
	},
	// 只能输入大写字母、数字、小数点
	majusculeAndNumberAndDot : {
		validator: function (value) {
			// 字母小写转换成大写
			this.value = this.value.toUpperCase();
			return /^[0-9a-zA-Z\.]+$/.test(value);
		},
		message: 'Format error'
	},
	// 只能输入大写字母，可以输入空格
	capitalLetter : {
		validator: function (value) {
			this.value = this.value.toUpperCase();
			return /^[ A-Z]*$/.test(value);
		},
		message: 'Format error'
	},
	// 只能输入大写字母、数字，可以输入空格
	lettersAndNumber : {
		validator: function (value) {
			this.value = this.value.toUpperCase();
			console.log(value);
			return /^[ A-Z0-9]*$/.test(value);
		},
		message: 'Format error'
	}
})