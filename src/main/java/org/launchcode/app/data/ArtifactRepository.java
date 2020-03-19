package org.launchcode.app.data;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtifactRepository extends CrudRepository<Artifact, Integer>{
}
