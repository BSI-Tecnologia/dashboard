package br.com.bsitecnologia.dashboard.controller.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;
import javax.inject.Inject;

import org.primefaces.model.SelectableDataModel;

import br.com.bsitecnologia.dashboard.dao.CargoDao;
import br.com.bsitecnologia.dashboard.model.Cargo;

public class CargoDataModel extends ListDataModel<Cargo> implements SelectableDataModel<Cargo>, Serializable {

	private static final long serialVersionUID = -4869668320073761326L;

	@Inject
	CargoDao cargoDao;
	
    public void setCargoList(List<Cargo> cargoList){
    	super.setWrappedData(cargoList);
    }  
	
	@Override
	public Object getRowKey(Cargo cargo) {
		return cargo.getId();
	}

	@Override
	public Cargo getRowData(String rowKey) {
		List<Cargo> equipeList = (List<Cargo>) getWrappedData();
		for (Cargo cargo : equipeList) {
			if (cargo.getId().equals(Integer.valueOf(rowKey))) {
				return cargo;
			}
		}
		return null;
	}

}
