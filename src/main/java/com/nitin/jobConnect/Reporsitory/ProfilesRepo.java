package com.nitin.jobConnect.Reporsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nitin.jobConnect.POJOs.Profiles;

@Repository
public interface ProfilesRepo extends JpaRepository<Profiles, Long> {

}
