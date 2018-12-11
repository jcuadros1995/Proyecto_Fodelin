package co.edu.sanmateo.com.fodelin.Model;

public class ItemResultados {


    private int ImagenTipo;
    private String Titulo;
    private String Documento;
    private String Fecha;
    private String Compañia;



    public ItemResultados (int imagentipo, String titulo, String documento, String fecha, String compañia){
        super();
        ImagenTipo = imagentipo;
        Titulo = titulo;
        Documento = documento;
        Fecha = fecha;
        Compañia = compañia;
    }


    public int getImagenTipo() {
        return ImagenTipo;
    }

    public String getTitulo() {
        return Titulo;
    }

    public String getDocumento() {
        return Documento;
    }

    public String getFecha() {
        return Fecha;
    }

    public String getCompañia() {
        return Compañia;
    }
}
