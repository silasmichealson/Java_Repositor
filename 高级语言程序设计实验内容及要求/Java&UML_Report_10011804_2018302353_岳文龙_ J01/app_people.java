package app;
class People
{ 
    protected double weight,height;
    public void speakHello()
    {
        System.out.println("hello");
    }
    public void averageHeight()
    {
    height=173;
    System.out.println("average height:"+height);
    }
    public void averageWeight()
    {
    weight = 70;
    System.out.println("average weight:"+weight);
    }
}

class ChinaPeople extends People
{
    public void speakHello()
    {
        System.out.println("你好，吃饭了吗");
    }
    public void averageHeight()
    {
        height = 173.0;
        System.out.println("average height:"+height);
    }
    public void averageWeight()
    {
        weight = 67.34;
        System.out.println("average weight:"+weight);
    }
	public void chinaGongfu()
	{
        System.out.println("坐如钟，站如松，睡如弓");
	}
}

class AmericanPeople extends People
{
    public void speakHello()
    {
        System.out.println("How do you do");
    }
    public void averageHeight()
    {
        height = 178.0;
        System.out.println("average height:"+height);
    }
    public void averageWeight()
    {
        weight = 85;
        System.out.println("average weight:"+weight);
    }
	public void americanBoxing()
	{
        System.out.println("How do you do");
	}
}

class BeijingPeople extends ChinaPeople
{
    public void speakHello()
    {
        System.out.println("您好，这里是北京");
    }
    public void averageHeight()
    {
        height = 180.0;
        System.out.println("average height:"+height);
    }
    public void averageWeight()
    {
        weight = 80;
        System.out.println("average weight:"+weight);
    }
	public void beijingOpera()
	{
        System.out.println("京剧术语");
	}
}

public class app_people
{
	public static void main(String args[])
	{
		ChinaPeople chinaPeople = new ChinaPeople();
		AmericanPeople americanPeople = new AmericanPeople();
		BeijingPeople beijingPeople = new BeijingPeople();
		chinaPeople.speakHello();
          americanPeople.speakHello();
          beijingPeople.speakHello();
		chinaPeople.averageHeight();
		americanPeople.averageHeight();
		beijingPeople.averageHeight();
		chinaPeople.averageWeight();
		americanPeople.averageWeight();
		beijingPeople.averageWeight();
         chinaPeople.chinaGongfu();
         americanPeople.americanBoxing();
         beijingPeople.beijingOpera();
         beijingPeople.chinaGongfu();
	}
}
