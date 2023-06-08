public class Time {

    private int value;

    public Time( int value ) {

        this.value = value;

    }

    private boolean validateTime(int timeValue) {

        return ((timeValue>0) && (timeValue<86401));//SegundosEmUmDia = 24*60*60 = 86400

    }

    private int TimeToSeconds( int hora, int min, int sec ) {

        return hora*3600 + min*60 + sec;

    }

    private String SecondsToTime(){

        String result = "";
        int hora;
        int min;
        int sec;
        hora = value/3600;
        min = (value % 3600)/60;
        sec = (value % 3600)%60;
        result = Integer.toString(hora) + ":" + Integer.toString(min) + ":" + Integer.toString(sec);

         return result;

    }

    public void setTime(int hora, int min, int seg) {

        int value = this.TimeToSeconds( hora, min, seg );
        if ( validateTime(value) ) {
            this.value = value;
        }
        else{
            this.value = 0;
        }

    }

    public String getTime() {

        String res = SecondsToTime();
        return res;

    }

    public void prnTime() {

        System.out.println( getTime() );

    }

    public boolean isAm() {

        if( value < 43200 ) {
            return true;
        }

        return false;

    }

    int cron( int outraHora ) {

        if( this.value > outraHora) {
            return this.value - outraHora;
        }else {
            return outraHora - this.value;
        }

    }

    void addSeconds( int secs ) {

        this.value += secs;

        if (this.value >= 86400) this.value = 0;

    }



}