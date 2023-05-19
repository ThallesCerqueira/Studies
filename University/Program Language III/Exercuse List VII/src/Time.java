import java.time.Instant;
import java.util.Date;

public class Time {
    private int hora;
    private int min;
    private int seg;

    public Time() {

        hora = 0;
        min = 0;
        seg = 0;

    }

    public Time(int hora ) {

        if( validateHour(hora) ) {
            this.hora = hora;
        }else{
            this.hora = 0;
        }

        min = 0;
        seg = 0;

    }

    public Time(int hora, int min ) {

        if( validateHour( hora ) && validateMinOrSec( min ) ) {
            this.hora = hora;
            this.min = min;
        }else{
            this.hora = this.min = 0;
        }

        this.seg = 0;

    }

    public Time(int hora, int min, int seg ) {

        if ( validateTime(hora, min, seg) ) {
            this.hora = hora;
            this.min = min;
            this.seg = seg;
        }else{
            this.hora = this.min = this.seg = 0;
        }

    }

    public Time(Time objeto ) {

        //Fiquei com dúvida nesta questão, crio abaixo o objeto, mas como faço para retornar?!
        Time auxiliar = new Time( objeto.hora, objeto.min, objeto.seg );

    }

    private boolean validateTime( int hora, int min, int seg ) {

        return validateHour(hora) &&
                validateMinOrSec(min) &&
                validateMinOrSec(seg);
    }

    private boolean validateHour(int hora){
        if((hora>=0) && (hora<25))
            return true;
        else
            return false;
    }

    private boolean validateMinOrSec(int param){
        if((param>=0) && (param<61))
            return true;
        else
            return false;
    }

    public void setTime(int hora, int min, int seg){
        if (validateTime(hora, min, seg)) {
            this.hora = hora;
            this.min = min;
            this.seg = seg;
        }
        else{
            this.hora = 0;
            this.min = 0;
            this.seg = 0;
        }
    }

    public String getTime(){
        String res = this.hora + ":" + this.min + ":" + this.seg;
        return res;
    }

    public void prnTime(){
        System.out.println(getTime());
    }

    public void addTime( int hora, int min, int seg ) {

        if( validateTime( hora, min, seg ) ) {
            this.hora += hora;
            this.min += min;
            this.seg += seg;
        }

        if(this.hora > 60) {
            this.hora = 0;
        }

        if( this.min > 60 ) {
            this.hora += 1;
            this.min = 0 ;
        }

        if ( this.seg > 60 ) {
            this.min += 1;
            this.seg = 0;

            if( this.min > 60 ) {
                this.hora += 1;
                this.seg = 0;
            }
        }

    }

    public void addTime( int hora, int min ) {
        addTime( hora, min, 0 );
    }

    public void addTime( int hora ) { addTime( hora, 0 ,0); }

    public void addTime( Time objeto ) {

        addTime( objeto.hora, objeto.min, objeto.seg );

    }

    public static Time diffTime( Time t1, Time t2 ) {

        int seg1, seg2, diferenca;
        Time diferencaTime;

        if ( t1.validateTime( t1.hora, t1.min, t1.seg ) && t2.validateTime( t2.hora, t2.min, t2.seg ) ) {

            seg1 = t1.timeToSec( t1.hora, t1.min, t1.seg );
            seg2 = t2.timeToSec( t2.hora, t2.min, t2.seg );

            diferenca = seg1 - seg2;

            if ( diferenca < 0 ) diferenca *= -1;

            diferencaTime = t1.SecToTime( diferenca );

            return diferencaTime;

        }

        return null;

    }

    private int timeToSec( int hora, int min, int seg ) {

        int aux;

        aux = hora * 60 * 60;
        aux += ( min * 60);
        aux += seg;

        return aux;

    }

    private Time SecToTime( int seg ) {

        Time time = new Time();
        int resto;

        time.hora = seg / 3600;
        resto = seg % 3600;

        time.min = resto / 60;
        time.seg = resto % 60;

        return time;
    }

    public static Time diffTime( Time t ) {

        Date data = new Date();
        Time novoTime;
        int diferenca;

        int t1 = t.timeToSec( data.getHours() ,data.getMinutes(), data.getSeconds() );
        int t2 = t.timeToSec( t.hora, t.min, t.seg );

        diferenca = t1 - t2;

        if (diferenca < 0 ) diferenca *= -1;

        novoTime = t.SecToTime( diferenca );

        return null;
    }

}