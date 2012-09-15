package br.com.bsitecnologia.dashboard.controller.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import br.com.bsitecnologia.dashboard.model.Equipe;

public class EquipeDataModel extends ListDataModel<Equipe> implements SelectableDataModel<Equipe>, Serializable {

	private static final long serialVersionUID = 3338983520215140709L;

	public void setEquipeList(List<Equipe> equipeList) {
		super.setWrappedData(equipeList);
	}

	@Override
	public Object getRowKey(Equipe equipe) {
		return equipe.getId();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Equipe getRowData(String rowKey) {
		List<Equipe> equipeList = (List<Equipe>) getWrappedData();
		for (Equipe equipe : equipeList) {
			if (equipe.getId().equals(rowKey)) {
				return equipe;
			}

		}
		return null;
	}

}
