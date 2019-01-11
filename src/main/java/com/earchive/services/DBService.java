package com.earchive.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.earchive.domain.Company;
import com.earchive.domain.ManagedGuard;
import com.earchive.domain.SimpleGuard;
import com.earchive.domain.Warehouse;
import com.earchive.domain.enums.TypeContainer;
import com.earchive.repositories.CompanyRepository;
import com.earchive.repositories.ContainnerRepository;
import com.earchive.repositories.WarehouseRepository;

@Service
public class DBService {
	
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private WarehouseRepository warehouseRepository;
	
	@Autowired
	private ContainnerRepository containnerRepostitory;
	
	
	public void instantiateTestDatabase() throws ParseException {
		
		
		/*Instanciando Companhias*/
		Company cp1 = new Company(null, "Smartscan");
		Company cp2 = new Company(null, "UFTM");
		
		companyRepository.save(Arrays.asList(cp1,cp2));
		
		/*Instanciando Armazéns*/
		
		Warehouse wh1 = new Warehouse(null, "Cedoc Matriz");
		Warehouse wh2 = new Warehouse(null, "Cedoc Filial");
		
		warehouseRepository.save(Arrays.asList(wh1,wh2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		SimpleGuard sc1= new SimpleGuard(null, "EA02155", "FOLHA DE PAGAMENTO", sdf.parse("17/11/2018"), TypeContainer.SIMPLEGUARD, wh1, cp1, "758525", "158");
		ManagedGuard mg1= new ManagedGuard(null, "B05011", "FUNCIONARIOS ATIVOS", sdf.parse("18/06/2016"), TypeContainer.MANAGEDGUARD, wh2, cp2,1258);
		SimpleGuard sc2= new SimpleGuard(null, "EA02156", "FOLHA DE PAGAMENTO", sdf.parse("19/11/2018"), TypeContainer.SIMPLEGUARD, wh1, cp1, "458778", "200");
		
		SimpleGuard sc3= new SimpleGuard(null, "EA02255", "FOLHA DE PAGAMENTO", sdf.parse("20/11/2018"), TypeContainer.SIMPLEGUARD, wh1, cp1, "7585455", "168");
		ManagedGuard mg2= new ManagedGuard(null, "B15021", "FUNCIONARIOS ATIVOS", sdf.parse("19/06/2016"), TypeContainer.MANAGEDGUARD, wh2, cp2,128);
		SimpleGuard sc4= new SimpleGuard(null, "EA02366", "FOLHA DE PAGAMENTO", sdf.parse("16/11/2018"), TypeContainer.SIMPLEGUARD, wh1, cp1, "422778", "203");
		

		SimpleGuard sc5= new SimpleGuard(null, "EB02155", "FOLHA DE PAGAMENTO", sdf.parse("17/11/2018"), TypeContainer.SIMPLEGUARD, wh1, cp1, "66525", "858");
		ManagedGuard mg3= new ManagedGuard(null, "C05021", "FUNCIONARIOS ATIVOS", sdf.parse("18/06/2016"), TypeContainer.MANAGEDGUARD, wh2, cp2,1258);
		SimpleGuard sc6= new SimpleGuard(null, "J040101", "FOLHA DE PAGAMENTO", sdf.parse("19/11/2018"), TypeContainer.SIMPLEGUARD, wh1, cp1, "4588", "200");
		
		SimpleGuard sc7= new SimpleGuard(null, "EA01251", "FOLHA DE PAGAMENTO", sdf.parse("20/11/2018"), TypeContainer.SIMPLEGUARD, wh1, cp1, "7585455", "168");
		ManagedGuard mg4= new ManagedGuard(null, "P15021", "FUNCIONARIOS ATIVOS", sdf.parse("19/06/2016"), TypeContainer.MANAGEDGUARD, wh2, cp2,128);
		SimpleGuard sc9= new SimpleGuard(null, "E01665", "FOLHA DE PAGAMENTO", sdf.parse("16/11/2018"), TypeContainer.SIMPLEGUARD, wh1, cp1, "422778", "203");
		
		
		containnerRepostitory.save(Arrays.asList(sc1,mg1,sc2,mg2,sc3,sc4,sc5,sc6,sc7,sc9,mg4,mg3));
		
		
	}

}
