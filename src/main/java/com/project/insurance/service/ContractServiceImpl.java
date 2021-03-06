package com.project.insurance.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.insurance.dao.AccidentDao;
import com.project.insurance.dao.ClientDao;
import com.project.insurance.dao.ContractDao;
import com.project.insurance.dao.InsuranceProductDao;
import com.project.insurance.dao.ManagerDao;
import com.project.insurance.dao.MedicalHistoryDao;
import com.project.insurance.exception.ContractInsertFailedException;
import com.project.insurance.model.Accident;
import com.project.insurance.model.Client;
import com.project.insurance.model.Contract;
import com.project.insurance.model.MedicalHistory;
import com.project.insurance.model.insurance.InsuranceProduct;
import com.project.insurance.model.manager.Manager;
import com.project.insurance.type.InsuranceProductType;

@Service
public class ContractServiceImpl implements ContractService{
	
	@Autowired
	private ContractDao contractDao;
	@Autowired
	private AccidentDao accidentDao;
	@Autowired
	private InsuranceProductDao insuranceProductDao;
	@Autowired
	private ClientDao clientDao;
	@Autowired
	private MedicalHistoryDao medicalHistoryDao;
	@Autowired
	private ManagerDao managerDao; 
	
	@Override
	public Contract searchByClientIdAndProductName(String clientId, String productName) throws SQLException {
		return insertContractData(contractDao.search(clientId, productName));
	}
	
	@Override
	public Accident searchByAccidentNum(int accidentNum) throws SQLException {
		return insertAccidentInfo(accidentDao.search(accidentNum));
	}

	@Override
	public ArrayList<Contract> searchListByApproval(boolean approval) throws SQLException{
		ArrayList<Contract> list = new ArrayList<Contract>();
		for(Contract contract : contractDao.findAll()) {
			if(contract.isApproval() == approval)
				list.add(contract);
		}
		return this.insertContractData(list);
	}

	@Override
	public ArrayList<Accident> searchAccidentListByProductType(InsuranceProductType insuranceProductType) throws SQLException{
		ArrayList<Accident> list = new ArrayList<Accident>();
		for (Accident accident : accidentDao.findAll()) {
			accident = this.insertAccidentInfo(accident);
			if (insuranceProductType == accident.getInsuranceProduct().getInsuranceProductType())
				list.add(accident);
		}
		return list;
	}

	@Override
	public ArrayList<Contract> searchListByInsuranceProductType(InsuranceProductType insuranceProductType) throws SQLException {
		ArrayList<Contract> list = new ArrayList<Contract>();
		for (Contract contract : this.searchListByApproval(true)) {
			if (contract.getInsuranceProduct().getInsuranceProductType() == insuranceProductType)
				list.add(contract);
		}
		return list;
	}

	@Override
	public ArrayList<Contract> searchListByExpiredDate(InsuranceProductType insuranceProductType) throws SQLException {
		ArrayList<Contract> list = new ArrayList<Contract>();
		for (Contract contract : this.searchListByInsuranceProductType(insuranceProductType)) {
			if (contract.getInsuranceExpiryDate().before(new Date()) ) 
				list.add(contract);
		}
		return list;
	}

	@Override
	public boolean deleteContract(Contract contract) throws SQLException {
		return contractDao.delete(contract);
	}

	@Override
	public boolean registerInsuranceProduct(Contract contract) {
		try {
			return contractDao.add(contract);
		}catch(SQLException e) {
			throw new ContractInsertFailedException(e);
		}
		
	}

	@Override
	public ArrayList<Contract> searchListBySalesPerson(String salesPerson) throws SQLException {
		return this.insertContractData(contractDao.searchBySalesPerson(salesPerson));
	}

	@Override
	public boolean modifyContract(Contract contract) throws SQLException {
		return contractDao.update(contract);
	}

	@Override
	public ArrayList<Accident> applyAccidentList() throws SQLException {
		ArrayList<Accident> list = new ArrayList<Accident>();
		for (Accident accident : accidentDao.findAll()) {
			list.add(this.insertAccidentInfo(accident));
		}
		return list;
	}

	@Override
	public boolean addApplyAccidentList(Accident accident) throws SQLException {
		return accidentDao.add(accident);
	}

	@Override
	public boolean deleteAccidentList(Accident accident) throws SQLException {
		return accidentDao.delete(accident);
	}
	
	private Contract insertContractData(Contract contract) throws SQLException{
		if(contract != null) {
			contract.setInsuranceProduct(insuranceProductDao.search(contract.getInsuranceProduct().getProductName()));
			Client client = clientDao.search(contract.getClient().getId());
			MedicalHistory medicalHistory = medicalHistoryDao.search(client.getId());
			Manager salesPerson = managerDao.search(contract.getSalesPerson().getId());
			client.getMedicalHistory().setClientCancerCareer(medicalHistory.getClientCancerCareer());
			client.getMedicalHistory().setFamilyCancerCareer(medicalHistory.getFamilyCancerCareer());
			client.getMedicalHistory().setNumberOfHospitalizations(medicalHistory.getNumberOfHospitalizations());
			client.getMedicalHistory().setNumberOfHospitalVisits(medicalHistory.getNumberOfHospitalVisits());
			contract.setClient(client);
			contract.setSalesPerson(salesPerson);
			return contract;
		}
		return null;
	}

	private ArrayList<Contract> insertContractData(ArrayList<Contract> list) throws SQLException{
		for(Contract contract : list) {
			contract.setInsuranceProduct(insuranceProductDao.search(contract.getInsuranceProduct().getProductName()));
			Client client = clientDao.search(contract.getClient().getId());
			MedicalHistory medicalHistory = medicalHistoryDao.search(client.getId());
			Manager salesPerson = managerDao.search(contract.getSalesPerson().getId());
			client.getMedicalHistory().setClientCancerCareer(medicalHistory.getClientCancerCareer());
			client.getMedicalHistory().setFamilyCancerCareer(medicalHistory.getFamilyCancerCareer());
			client.getMedicalHistory().setNumberOfHospitalizations(medicalHistory.getNumberOfHospitalizations());
			client.getMedicalHistory().setNumberOfHospitalVisits(medicalHistory.getNumberOfHospitalVisits());
			contract.setClient(client);
			contract.setSalesPerson(salesPerson);
		}
		return list;
	}
	
	private Accident insertAccidentInfo(Accident accident) throws SQLException {
		InsuranceProduct insuranceProduct = insuranceProductDao.search(accident.getInsuranceProduct().getProductName());
		Client client = clientDao.search(accident.getClient().getId());
		accident.setInsuranceProduct(insuranceProduct);
		accident.setClient(client);
		return accident;
	}

	@Override
	public ArrayList<Contract> searchListByClientId(String clientId) throws SQLException {
		return contractDao.searchByClient(clientId);
	}

}
