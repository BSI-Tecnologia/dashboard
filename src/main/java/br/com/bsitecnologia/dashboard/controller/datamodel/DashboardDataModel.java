package br.com.bsitecnologia.dashboard.controller.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import br.com.bsitecnologia.dashboard.util.BaseEntity;

@SuppressWarnings("unchecked")
public class DashboardDataModel<T extends BaseEntity> extends ListDataModel<T> implements SelectableDataModel<T>, Serializable {

	private static final long serialVersionUID = -4869668320073761326L;

    public void setList(List<T> list){
    	super.setWrappedData(list);
    }  
	
	@Override
	public Object getRowKey(T t) {
		return t.getId();
	}

	@Override
	public T getRowData(String rowKey) {
		List<T> list = (List<T>) getWrappedData();
		for (T t : list) {
			if (t.getId().equals(Integer.valueOf(rowKey))) {
				return t;
			}
		}
		return null;
	}

}
