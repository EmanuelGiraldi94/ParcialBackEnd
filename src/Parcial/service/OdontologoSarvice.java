package Parcial.service;


import Parcial.dao.IDao;
import Parcial.model.Odontologo;

import java.util.List;

public class OdontologoSarvice {


    private IDao<Odontologo> odontologoDao;

    public OdontologoSarvice(IDao<Odontologo> odontologoDao) {
        this.odontologoDao = odontologoDao;
    }

    public  Odontologo guardarOdontologo(Odontologo odontologo){

        return odontologoDao.guardar(odontologo);
    }
    public List<Odontologo> listarTodo(){

        return  odontologoDao.listar();
    }
}
