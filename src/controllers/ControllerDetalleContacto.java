
package controllers;
import models.ModelDetalleContacto;
import views.ViewDetalleContacto;


public class ControllerDetalleContacto {
    public ModelDetalleContacto modelDetalleContacto;
    public ViewDetalleContacto viewDetalleContacto;

    /**
     * Controllador ControllerDetalleContacto que une el modelDetalleContacto y
     * viewDetalleContacto.
     * @param modelDetalleContacto
     * @param viewDetalleContacto 
     */
    public ControllerDetalleContacto(ModelDetalleContacto modelDetalleContacto, ViewDetalleContacto viewDetalleContacto) {
        this.modelDetalleContacto = modelDetalleContacto;
        this.viewDetalleContacto = viewDetalleContacto;
        initView();
    }
    
    /**
     * Muestra el nombre e email almacenados en el modelDetalleContacto en el 
     * viewDetalleContacto.
     */
    public final void initView(){
        viewDetalleContacto.jl_nombre.setText(modelDetalleContacto.getNombre());
        viewDetalleContacto.jl_email.setText(modelDetalleContacto.getEmail());
        viewDetalleContacto.jl_telefono.setText(modelDetalleContacto.getTelefono());
    }
}
