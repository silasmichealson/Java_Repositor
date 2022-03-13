class student{
    String name;
    double num[] = new double[4];
    double cnum[] = {4,7/2,3,3};
    double Gpa;
    void setnumb(double math,double english,double data_structure,double database)
    {
        num[0] = math;
        num[1] = english;
        num[2] = data_structure;
        num[3] = database ;
    }
    void cout()
    {
        double x,y,temp;
        x= y =0;
        for(int i= 0 ; i < 4 ;i++)
        {
            if(num[i]!=0)
            {
                x = x+ num[i]*cnum[i];
                y = y+ cnum[i];
            }
        }
        temp = x/y;
        Gpa = temp;
    }
}
public class GPA {
    public static void main(String[] args) throws Exception {
       student a = new student();
       student b = new student();
       student c = new student();
       a.name = "张一";
       b.name ="李一";
       c.name = "赵一";
       a.setnumb(71.5, 80.4, 95.5, 0.0);
       b.setnumb(78.5, 0, 54.5, 60.5);
       c.setnumb(88.5, 92.5, 71.5, 0);
        a.cout();
        b.cout();
        c.cout();
        System.out.println(a.Gpa+" "+b.Gpa+" "+c.Gpa);

    }
}