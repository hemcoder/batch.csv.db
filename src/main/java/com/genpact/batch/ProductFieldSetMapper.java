package com.genpact.batch;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.genpact.batch.model.Product;

public class ProductFieldSetMapper implements FieldSetMapper<Product> {

	public Product mapFieldSet(FieldSet fieldSet) throws BindException {
		Product product = new Product();
        product.setId( fieldSet.readInt( "id" ) );
        product.setName( fieldSet.readString( "name" ) );
        product.setDescription( fieldSet.readString( "description" ) );
        product.setQuantity( fieldSet.readInt( "quantity" ) );
        return product;
	}

}
