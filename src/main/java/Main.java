import GUI.KWICUI;
import filters.Alphabetizer;
import filters.CircularShifting;
import filters.Input;
import filters.Output;

public class Main {

    public static void main(String [] args) {
        Input input = new Input();
        input.agregarTitulo("el señor de los anillos");
        input.agregarTitulo("essentials of bussiness communications");
        input.agregarTitulo("encycopledia of research on library");
        input.agregarTitulo("harry potter y el caliz de fuego");
        input.agregarTitulo("los anillos del señor");
        input.agregarPalabraNoClave("el");
        input.agregarPalabraNoClave("de");
        input.agregarPalabraNoClave("los");
        input.agregarPalabraNoClave("los");
        input.agregarPalabraNoClave("uno");
        input.agregarPalabraNoClave("la");
        input.agregarPalabraNoClave("y");
        input.agregarPalabraNoClave("on");
        input.agregarPalabraNoClave("of");
        
        KWICUI ventana= new KWICUI();
        
        
        //for (int i = 0; i < input.getTitles().size(); i++) {
            CircularShifting circularShifting = new CircularShifting(input.getTitles(), input.getPalabrasNoClave());
            Alphabetizer alphabetizer = new Alphabetizer(circularShifting.circularShiftsProcess());
            Output output = new Output(alphabetizer.alfabetizar());
            System.out.println(output);
        //}
    }

}
