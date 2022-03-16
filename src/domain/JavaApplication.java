package domain;
import java.util.*;
import java.util.function.Predicate;

public class JavaApplication {

    public static void main(String[] args) {
        Factura f=new Factura("ordenador",1000, 2, new Date(2020, Calendar.DECEMBER, 3), "a1");
        Factura f2=new Factura("movil",300, 3,new Date(2021, Calendar.MARCH, 18), "a2" );
        Factura f3=new Factura("impresora",200, 5, new Date(2021, Calendar.MAY,15), "a3");
        Factura f4=new Factura("imac",1500, 1, new Date(2022, Calendar.FEBRUARY, 30), "a4");

        List<Factura> lista= new ArrayList<Factura>();
        lista.add(f);
        lista.add(f2);
        lista.add(f3);
        lista.add(f4);

        //Predicados

        Predicate<Factura> predicadoMayorImporte = new Predicate<Factura>() {
                @Override
                public boolean test(Factura t) {
                    return t.getImporte()>300;
                }
            };

        Predicate<Factura> predicadoMayorCantidad = new Predicate<Factura>() {
            @Override
            public boolean test(Factura t) {
                return t.getCantidad()>2;
            }
        };

        Predicate<Factura> predicadoMayorFecha = new Predicate<Factura>() {
            @Override
            public boolean test(Factura t) {
                Date hoy = new Date();
                return t.getFecha().before(new Date(2021, Calendar.MAY, 2));
            }
        };

        Predicate<Factura> predicadoCodigo = new Predicate<Factura>() {
            @Override
            public boolean test(Factura t) {
                return t.getCodigo() == "a12";
            }
        };

        //Filtros

        Factura facturaMayorImporte= lista.stream()
            .filter(predicadoMayorImporte)
            .findFirst()
            .get();

        Factura facturaMayorCantidad = lista.stream()
                .filter(predicadoMayorCantidad)
                .findFirst()
                .get();
        Factura facturaMayorFecha = lista.stream()
                .filter(predicadoMayorFecha)
                .findFirst()
                .get();

        System.out.println("La factura con mayor importe tiene: "+facturaMayorImporte.getImporte());
        System.out.println("La factura con mayor cantidad tiene: "+facturaMayorCantidad.getCantidad());
        Date fecha = facturaMayorCantidad.getFecha();
        System.out.println("La factura antes del 02/05/2021 es el: "+fecha.getDate()+"/"+fecha.getMonth()+"/"+fecha.getYear());

    }

}