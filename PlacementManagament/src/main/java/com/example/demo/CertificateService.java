package com.example.demo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CertificateService 
{
		//it will create object using Autowired concepts
		@Autowired
		private CertificateRepository repo;
		
		//to retrieve all the data of Certificate class
		public List<Certificate> listAll()
		{
			return repo.findAll();
		}

		//insert / update /create data
		public void create(Certificate c)
		{
			repo.save(c);
		}
		
		//to retrieve a single record
		public Certificate retrieve(Integer id)
		{
			return repo.findById(id).get();
		}
		
		//to delete data
		public void delete (Integer id)
		{
			repo.deleteById(id);
		}
}
