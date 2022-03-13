# java学习
## Java环境配置
jdk下载安装
将jdk/bin加入path环境变量
## Java指令
Javac 编译

Java 运行

例子：helloworld编译运行

1. 编写helloworld.java文件

2. javac helloworld.java 生成 .class 文件
3. Java helloworld 运行文件

## Java语法
###1. 注释 
 - 单行注释 //
 - 多行注释 /××/
 - 文档注释 /×××××/


 **Java 程序基本组成是类**

 **类的定义格式 public class 类名 {}**

**main 方法是程序的入口方法，代码的执行从main开始**

###2. 关键字
static public main 。。。。
###3. 常量
1. 字符串常量  “xargagaew”
2. 整数常量    382，-23 
3. 小数常量    23.213
4. 字符常量    ‘a’
5. 布尔常量    true，flase
6. 空常量      null

    public class helloword{
	public static void main(String[] args)
	{
		System.out.println("hello world");
		System.out.println("你好");
		System.out.println("=============");
		System.out.println(3);
		System.out.println(-1);
		System.out.println("=============");
		System.out.println(1.23);
		System.out.println(-5.12);
		System.out.println("=============");
		System.out.println('a');
		System.out.println('我');
		System.out.println("=============");
		System.out.println(true);
		System.out.println(false);
		System.out.println("=============");  
		System.out.println(Null);  
	//nul不能打印  
		}
	}

    hello world   
	你好   
    3  
     -1  
     1.23  
     -5.12  
    a  
    我  
    true  
    false