public class DataHoraComposicao {

    Data data;
    Time hora;

    public DataHoraComposicao() {

        this.data = new Data();
        this.hora = new Time();

    }

    public String toString() {

        data.imprimirData();
        hora.prnTime();

        return null;
    }

    public boolean isEqual( DataHoraComposicao dataHora ) {

        return dataHora.data == this.data && dataHora.hora == this.hora;

    }

    public boolean isGreather( DataHoraComposicao outroObjeto ) {

        return !isLower( outroObjeto );

    }

    public boolean isLower( DataHoraComposicao outroObjeto ) {

        return this.data.isPrevious( outroObjeto.data.getDia(), outroObjeto.data.getMes(), outroObjeto.data.getAno() );

    }

}
