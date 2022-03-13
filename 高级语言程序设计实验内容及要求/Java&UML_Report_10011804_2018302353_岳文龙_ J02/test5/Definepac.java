package MainPackage;

public class ParentClass{
    int n;
    ParentClass(int m){
        n =m;
    }
    ParentClass()
    {
        n=0;
    }
}

class SubClass extends ParentClass{
    
    SubClass()
    {
        super(1);
    }
}