
package com.moha.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DemoRepository extends JpaRepository<Demo,Long>{
    Demo findByName(String name);

    Demo findById(Integer id);

}
