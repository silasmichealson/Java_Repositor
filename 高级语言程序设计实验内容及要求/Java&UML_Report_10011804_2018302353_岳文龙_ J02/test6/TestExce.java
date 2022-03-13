class UserException extends Exception{
    private int idnumber;
    public UserException(String message,int id){
      super(message);
      this.idnumber=id;}
    public int getId(){
      return idnumber;
     }
   }

   public class TestExce{
       public void regist(String ad) throws UserException{
        if(ad == "1")
        {
            throw new UserException("字符串为空不合理", 1);
        }
       }
       public void mananger()
       {
           try{
               regist("1");
           }catch(UserException e){
               System.out.println("转换出错类别"+e.getId());
           }
           System.out.println("本次转换结束");

        
           }
           public static void main(String[] args) {
               TestExce t=new TestExce();
               t.mananger();
        }
       }
