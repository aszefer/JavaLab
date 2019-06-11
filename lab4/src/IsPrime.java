public class IsPrime {
    private Long n;

    public boolean IsPrime(Long nb){
        n = nb;

        for(int i = 2; i < n; i++){
            if (n%i==0)
                return false;
        }
        return true;
    }
}
