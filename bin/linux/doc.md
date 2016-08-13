# linux
##	一、linux 操作系统概述
### 1.常见操作系统
- 服务端操作系统 ： linux、unix、windows server 
- 单机操作系统 ： windows（dos 、ucdos、win95、win98、win2000、xp、vista、win7、win8） MAC 、linux（ubuntu)
- 移动操作系统 Android、IOS 、Windows phone

### 2.linux操作系统介绍
- 为什么要学习linux操作系统
	1. 大部分服务端都采用linux ，JEE部署到服务器中
	2. 一些企业和学校采用linux研发和教学
	3. 很多嵌入式开发 用linux
	4. 云计算、大数据 是集群网  linux : centos
- 特点
	1. 开放、开源、多用户的网络操作系统
	2. 基于unix(unix-->minix-->linux(linus :林纳斯 芬兰 ))，可以定制内核
	3. 加入了GNU组织（自由软件组织 ，copyLeft） ，通过GPL（通用公共许可） 许可对外发布  
- linux组成
	1. linux内核（linus 团队管理）
	2. shell ：用户与内核交互的接口
	3. 文件系统 ： ext3、ext4 等  windows 有 fat32  、ntfs
	4. 第三方应用软件
- linux操作系统版本
	1. 内核版本 (linus 团队管理)  4.8
	2. 发行版本  :一些软件公司以内核为基础，再添加一些软件和文档形成发行版本
		- red hat  ： rhel ，centos
	   - debian   ： debian，ubuntu（桌面）
	   - android
	   
	   
## 二、安装linux系统
## 三、linux系统环境
	默认有6个命令交互通道和一个图形界面交互通道，默认进入到的是图形界面通道
     命令交互模式切换：ctrl+alt+f1---f6
     图形交互界面 ctrl+alt+f7

### 1.图形界面交互模式
     - terminal： 图形界面的命令终端，它是图形界面交互通道的延伸，要依赖于图形界面

### 2.命令交互模式

	命令提示符：
	l@G450U:~$ 
        - l：用户名
	- G450U ：主机名
	- ~  ：路径 ，假如当前的路径正好是 该用户存放数据的根目录 ，则显示~
	- $ :用户的类型  $代表普通用户  #  代表 超级用户

### 3.linux文件系统
	- 目录结构
		bin:存放可执行的二进制文件
		boot:存放系统的引导文件
		dev:存放设备文件的目录。linux把设置当做文件来处理
		etc:存放系统的配置文件的目录
		home:存放所有用户文件的根目录，root用户除外
		lib:共享库
		usr:存放应用的默认安装路径
		opt:自定义存放应用程序位置
		mnt:临时文件系统的挂靠点
    - 文件权限分析
      w ：可写   r： 只读  x：可执行  - ：无权限
      文件权限
		1. 字符表示法
         drwxr-xr-x
		1 字符 ：文件的类型  - ：普通文件  d ：文件夹  c ：串口文件  l ：连接文件
		2-4 字符  ： 该文件的属主用户的权限 
		5-7  字符 ： 与属主用户同一组的其他用户的权限
		8-10 字符 ：  不同组的其他用户的权限
		
		2. 数字表示法	421
	   -rw-r--r--   ：文件的默认权限   644
	   drwxr-xr-x   ： 目录的默认权限  755

### 4、linux的常用命令
* 1.注销、关机、重启

		注销 ：logout ：登出 、exit
		关机 ：shutdown -h 时间
			- 时间 ：
			    1. now :马上
			    2. 12.30 ：指定具体时间
			    3. 3  ：几分钟以后
			sudo ： superuser do ：由超级用户来执行该命令
				要配置sudo 命令 ： 授权 哪些用户能执行哪些命令
				由超级用户配置  sudo 
					/etc/sudoers
		重启：shutdown -r  时间
				
* linux基本命令 ：文件操作命令

		ls:查看目录内容
			－l:查看详细信息
			-a:查看所有文件
		mkdir:新建目录
		cd：进入某目录
			./当前目录	../上级目录
		touch:新建文件
		echo：
		cat、mor
		cp、mv、rm：复制、移动、删除
		wc
		ln
		pwd：查看当前所在目录
		管理命令：|
		重定向：
		passwd
		su
* linux 系统命令
       