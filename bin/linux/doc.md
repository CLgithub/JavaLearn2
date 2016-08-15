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
		
		man 命令：查看该命令的帮助文档
		ls:查看目录内容
			－l:查看详细信息
			-a:查看所有文件
		mkdir:新建目录
		cd：进入某目录
			./当前目录	../上级目录
		touch:新建文件
		echo：把内容重定向到指定的文件中，有则打开，无则创建
			echo "abc">a.txt		覆盖模式
			echo "abc">>a.txt		追加模式
		cat、more:查看文件内容
			－cat：查看文件内容
			－more：分页查看文件内容
		cp、mv、rm：复制、移动(重命名)、删除
			-f:假如要删除的文件不存在，也不提示
			-r:递归
		wc：word count：统计文件字符数
			1       1       2 a.txt
			行数	单词数		字节数
		ln:创建连接文件：
			默认创建的是硬链接,类似复制，当是两个文件会同步
				ln a.txt b.txt（a.txt原文件，b.txt新文件）
			-s:创建的是软链接:相当于快捷方式
				ln -s a.txt a.link
		pwd：查看当前所在目录
		|:管理命令,把前面的输出作为后面的输入
		例如：la|wc
		重定向：
			echo "abc">a.txt		覆盖模式
			echo "abc">>a.txt		追加模式
		passwd:设置密码，ubuntu默认root账号是没有开启，只要素质root密码即可开启
			sudo passwd root
		su	切换目录
		
* linux 系统命令
	
		stat:查看文件详细信息
			l@G450U:~/桌面/test$ stat a.txt 
			  文件：'a.txt'
			  大小：4         	块：8          IO 块：4096   普通文件
			设备：808h/2056d	Inode：1177451     硬链接：1
			权限：(0664/-rw-rw-r--)  Uid：( 1000/       l)   Gid：( 1000/       l)
			最近访问：2016-08-13 14:48:32.674950696 +0800
			最近更改：2016-08-13 14:48:23.894857232 +0800
			最近改动：2016-08-13 14:48:23.894857232 +0800
			创建时间：-

		who与whoami
			who:查看在线用户
			whoami:查看当前自己的用户
		hostname:查看主机名
		uname：查看内核信息
			-a
		top:显示当前耗时的进程信息
		ps：显示当前进程的快照
			-axu
		du:显示文件的大小信息
		df:磁盘的使用情况
		ifconfig：查看 设置网卡配置
			设置ip地址
			静态设置ip
				sudo ifconfig eth0 192.168.1.103 netmask 255.255.255.0
		ping:测试与目标主机的连接情况
		clear:清除屏幕
		kill:杀死进程
			kill pid
		netstat:查看网络连接情况
		useradd:
			查看用户信息:sudo cat /etc/passwd
				l:x:1000:1000:l,,,:/home/l:/bin/bash
				l:用户名
				x:密码	已经加密，存放在/etc/shadow
				1000:账号id	userid
				1000:组id	group id
				l,,,：账号描述
				/home/l:该账户存放文件的默认位置
				/bin/bash：该用户的shell脚本的解析方式
			创建用户
				useradd 用户名 -d /home/用户名 -s /bin/bash
				-d:指定新用户的home
				-s:指定新用户的shell解析方式
				步骤：
					1.创建 /home/l2	目录
					2.执行 useradd 命令
					3.用passwd 设置密码
					4.su 切换用户
					
### 5、打包和压缩	

	压缩文件格式
		windows：zip、rar
		linux：gz、bzio、zip
	1.tar：打包、拆包命令
		tar -cxzjvf <打包后的文件> <欲打包的目录>
			-c:创建一个归档文件，即打包文件夹
			-x:拆包
			-z:以gzip格式压缩，默认压缩倍数 6倍（0-9）
			-j:以bzip2格式压缩
			-v:显示打包或拆包的文件信息
			-f:后面紧接一个归档文件
		打包：
			如将当前目录下的jee目录打包成jee.tar文件
				tar -cvf jee.tar ./jee/
			将当前目录下的多个文件打包：
				tar cvf ab.zip a.txt b.ini
		拆包：
			tar -xvf ab.zip
	2.gzip、bzip2压缩与解压
		1.压缩文件
			对打包好的文件进行压缩
				gzip ab.zip
		2.解压文件
			gzip -d ab.zip
				-d:解压
	3.打包及解压
		打包及压缩
			tar -czvf jee.tar.gz jee/
		拆包及解压
			tar -xzvf jee.tar.gz
			
## 软件管理

	windows ： .exe     安装 、卸载 
       安装：  mysql.exe  cc.exe   
       卸载 ： 该软件唯一的标识  ，包名   alibaba
    android : *.apk   卸载 包名
    red hat ：*.rpm 
    ubuntu  : 对debian的升级  *.deb 格式	
    
    1.安装软件
       - dpkg ：debian  package 
          离线安装：
	  安装 ： sudo dpkg - i  <文件名> 
	    -i ：install
	   命令：sudo dpkg -i ./tree_1.6.0-1_i386.deb
	  卸载 ： sudo dpkg - r  <包名> 
	    -r ：remove
           命令：sudo dpkg -r tree
       - apt-get  ：advance  package  tools 
       　　对dpkg命令的升级，在线安装
	  安装 ： sudo apt-get -install  <包名>
	  卸载 ： sudo apt-get -remove  <包名>
	  
## 实现远程安全访问linux系统
    
    1.通过ssh实现安全远程访问linux系统 
       ssh ：secure shell(安全的外壳)
         加密：
	   1. 对称加密 （加密密钥与解密密钥相同）
	      des 、aes
	   2. 非对称加密（加密密钥与解密密钥不同）
	      RSA ：公钥、私钥 
	 数字摘要：
	   md5 \sha1 
	    
      
       1. 查看是否安装了ssh服务端与客户端
         sudo apt-cache policy openssh-client openssh-server
       2. 安装ssh 服务端与客户端软件
          sudo dpkg -i ./ssh/*
          
## 配置java开发环境

	2. 安装jdk
       进入 root用户
       实现步骤：
        1. jdk 存放在哪里  /opt
		2. 把软件拷贝到/opt
		3. 绿色软件，解压 
		4.设置环境变量
		   vim /etc/profile 
		export JAVA_HOME="/opt/jdk1.6.0_39"
	        export PATH="$JAVA_HOME/bin:$PATH"
		5. 刷新配置 ，让配置生效
		   source /etc/profile
		6. 编写Demo.java,测试 
		   -javac Demo.java
	           - java Demo

    3. 安装tomcat 
       步骤：
        1. 安装在哪里 /opt
		2. 拷贝、解压
		   tar -xzvf  apache-tomcat.tar.gz
		3. 运行
		   - ./startup.sh
		   - ./shutdown.sh
       
      
    4. 安装Eclipse
       步骤：
         1.安装在/opt
		 2. 拷贝、解压
		   cp eclipse.tar.gz  /opt
		   tar -xzvf  eclipse.tar.gz  
          
		