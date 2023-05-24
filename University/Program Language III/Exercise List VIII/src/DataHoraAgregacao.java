public class DataHoraAgregacao {

    Data data;
    Time hora;

    public DataHoraAgregacao( Data data, Time hora ) {

        this.data = data;
        this.hora = hora;

    }

    public String toString() {

        data.imprimirData();
        hora.prnTime();

        return null;
    }

    public boolean isEqual( DataHoraAgregacao dataHora ) {

        return dataHora.data == this.data && dataHora.hora == this.hora;

    }

    public boolean isGreather( DataHoraAgregacao outroObjeto ) {

        return !isLower( outroObjeto );

    }

    public boolean isLower( DataHoraAgregacao outroObjeto ) {

        return this.data.isPrevious( outroObjeto.data.getDia(), outroObjeto.data.getMes(), outroObjeto.data.getAno() );

    }

}
