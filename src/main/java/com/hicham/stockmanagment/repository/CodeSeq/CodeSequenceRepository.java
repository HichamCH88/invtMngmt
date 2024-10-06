package com.hicham.stockmanagment.repository.CodeSeq;

import com.hicham.stockmanagment.model.CodeSeq.CodeSequence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeSequenceRepository extends JpaRepository<CodeSequence,Integer> {
    CodeSequence findByType(Integer type);
}
