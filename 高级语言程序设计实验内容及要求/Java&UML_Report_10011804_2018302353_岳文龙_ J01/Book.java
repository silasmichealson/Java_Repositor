//package book;

public class Book{
    String Title;
    int Pdate_y;
    int Pdate_m;
    int Pdate_d;
    int Words_numb;
    double nprice;
   public void setbook(String name,int y,int m,int d,int n){
            Title = name;
            Pdate_y = y;
            Pdate_m = m;
            Pdate_d =d;
            Words_numb = n;
    }
    public void price(int Word_numb,int Pdate_m){
        double p = 0;
        if(Pdate_m>6 && Pdate_m < 13)
        {
            p = Word_numb / 1000 * 35 * 1.18;
        }
        else if(Pdate_m>=0 && Pdate_m <=6)
        {
            p = Word_numb / 1000 * 35 * 1.2;
        }
        if(p != 0)
        {
           nprice = p;
        }
        else
        {
            System.out.println("illegal input");
        }
    }
}