package br.com.bsitecnologia.dashboard.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.MeterGaugeChartModel;

import br.com.bsitecnologia.dashboard.dao.CargoDao;
import br.com.bsitecnologia.dashboard.model.Cargo;

@ConversationScoped
@Named
public class RichBean implements Serializable {

    private static final long serialVersionUID = -2403138958014741653L;
    private String name = "Bruno";
    private MeterGaugeChartModel meterGaugeModel;
    private Integer speed = 100; 
    
    @Inject
    CargoDao cargoDao;
    
    @Inject
    Conversation conversation;
    
    @PostConstruct
    public void teste(){
    	conversation.begin();
    	 System.out.println("post construct: initialize");
         createMeterGaugeModel(speed);  
         name = "John Bruno";
    }
    
    public String getName() throws Exception {
    	Cargo cargo = new Cargo();
    	cargo.setNome("insert select e update teste");
    	System.out.println("teste save " + cargoDao.save(cargo).getId());
    	Cargo cargoLido = cargoDao.findAll().get(0);
    	System.out.println("TESTE CARGO DAO: " + cargoLido.getNome());
    	cargoLido.setNome("insert select e update teste - EDITADOOo LERO");
    	cargoDao.save(cargoLido);
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
  
    private void createMeterGaugeModel(Number speed) {  
    	
        @SuppressWarnings("serial")
		List<Number> intervals = new ArrayList<Number>(){
		{  
            add(20);  
            add(50);  
            add(120);  
            add(220);  
        }};  
  
        setMeterGaugeModel(new MeterGaugeChartModel(speed, intervals));  
    }

	public MeterGaugeChartModel getMeterGaugeModel() {
		return meterGaugeModel;
	}

	public void setMeterGaugeModel(MeterGaugeChartModel meterGaugeModel) {
		this.meterGaugeModel = meterGaugeModel;
		System.out.println("############ setando meterGaugeModel: "+this.meterGaugeModel.getValue());
	}

	public Integer getSpeed() {
		return speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
	}
	
	public void changeMeters(){
		createMeterGaugeModel(speed);
		System.out.println("############ setando meterGaugeModel: "+this.meterGaugeModel.getValue());
	}
	
}
