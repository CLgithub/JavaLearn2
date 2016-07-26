##jquery
###9大选择器
####1.基本选择器（基本的选择）
	* 根据id选择		
		$('#id')
	* 根据class选择
		$('.className')
	* 根据元素名称选择
		$('div')
	* 选择所有元素
		$('*')
	* 组合选择		,
		$('#id,div')		//和
####2.层级选择器（选择子孙或兄弟）
	子元素>		后面的所有兄弟元素~		所有兄弟元素siblings
	* 内所有某元素
		$('div span')				//div元素下的所有span元素，包含子孙元素
	* 所有子元素
		$('div>span')				//div元素下的所有span子元素，不包含孙元素
	* 下一个
		$('#one+div')				//id为one的下一个div元素
	* 后面的所有兄弟元素
		$('＃one~div')				//id为one的后面的所有div兄弟元素
	* 所有兄弟元素	
		$('#one').siblings('div')		//id为one的所有div兄弟元
####3.属性选择器	[]（根据属性选择）
	属性[]	等于＝	不等于!=	以xxx开头^=	以xxx结尾$=	包含*=	
	* 含有某属性的某元素
		$('div[title]')					//包含title属性的div元素
	* 某属性等于某值的某元素
		$('div[title=test]')			//title属性等于test的div元素
	* 某属性不等于某值的某元素
		$('div[title!=test]')		
	* 某属性以xxx开头的某元素
		$('div[title^=te]')				//title属性以te开头的div元素
	* 某属性以xxx结尾的某元素
		$('div[title$=est]')
	* 某属性包含xxx的某元素
		$('div[title*=es]')
	* 组合选择
		$('div[id][title*=es]')		//含有属性id切title属性包含es的div元素
	
	
####4.基本过滤选择器	:	(在基本选择的基础上，用:过滤出想要的)
	过滤:	第一个first	最后一个last	偶数even	奇数odd		索引：等于eq,大于gt,小于lt		索引标题元素header
	* 选出第一个xxx元素
		$('div:first')
	* 选出最后一个xxx元素
		$('div:last')
	* 选出class不为one的所有xxx元素
		$('div:not(.one)')
	* 选出class为one的所有xxx元素
		$('div:.one')
		$('div[class=one]')
	* 选出索引为偶数的xxx元素
		$('div:even')
	* 选出索引为基数的xxx元素
		$('div:odd')
	* 选出索引＝3的xxx元素
		$('div:eq(3)')
	* 选出索引>3的xxx元素
		$('div:gt(3)')
	* 选出索引<3的xxx元素
		$('div:lt(3)')
	* 选出所有标题元素
		$(":header")

####6.可见过滤选择器
	过滤可见的visible	过滤不可见的hidden

####5.内容过滤选择器
	有某内容的某元素contains	有某子元素的某元素has	内容为空的某元素empty	内容不为空的某元素parent

####7.子元素过滤选择器
	子元素过滤，‘ :’	过滤第x个子元素nth-child(x)	第一个first-child	最后一个last-child	唯一的子元素only-child

####8.表单对象属性过滤选择器
####9.表单选择器

###主要分为４类：

	*　基本选择
	*　层级选择
	*　属性选择
	*　过滤
		一般过滤‘:’
		子过滤‘ :’
	* 表单的单多选
