package org.kb141.persistence;

import java.util.List;

import org.kb141.domain.FileVO;
import org.springframework.stereotype.Repository;
@Repository 
public class FileDAOImpl extends AbstractDAO<FileVO,Integer> implements FileDAO {
	
	
	public FileDAOImpl(){
		this.mapperName = "FileMapper";
	}

	
	

}
