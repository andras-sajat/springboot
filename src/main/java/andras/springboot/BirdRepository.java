package com.andrastoth.mavenfirsttry;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;

@RepositoryRestResource
interface BirdRepository extends JpaRepository <Bird, Long> {
	Collection<Bird> findByBirdName (@Param("bn") String bn);
	Collection<Bird> findByBirdSize (@Param("bs") String bs);
}

@Component
class BirdResourceProcessor implements ResourceProcessor<Resource<Bird>>{

	@Override
	public Resource<Bird> process(Resource<Bird> reservationResource) {
		reservationResource.add(new Link("http://s3.com/imgs/"
						+reservationResource.getContent().getId()+".jpg", "photo"));
		return reservationResource;
	}
	
}