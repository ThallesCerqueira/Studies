public class DataHoraAssociacao {

    Data data;
    Time hora;

    public DataHoraAssociacao(Data data, Time hora ) {

        this.data = data;
        this.hora = hora;

    }

    public String toString() {

        data.imprimirData();
        hora.prnTime();

        return null;
    }

    public boolean isEqual( DataHoraAssociacao dataHora ) {

        return dataHora.data == this.data && dataHora.hora == this.hora;

    }

    public boolean isGreather( DataHoraAssociacao outroObjeto ) {

        return !isLower( outroObjeto );

    }

    public boolean isLower( DataHoraAssociacao outroObjeto ) {

        return this.data.isPrevious( outroObjeto.data.getDia(), outroObjeto.data.getMes(), outroObjeto.data.getAno() );

    }

}
