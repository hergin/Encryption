package io.github.hergin.encryption.utils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrimePairList {

	List<PrimePair> list;
	Set<BigInteger> set;

	public PrimePairList() {
		list = new ArrayList<>();
		set = new HashSet<>();
	}

	public PrimePairList(List<PrimePair> list, Set<BigInteger> set) {
		this.list = list;
		this.set = set;
	}

	public List<PrimePair> getList() {
		return list;
	}

	public Set<BigInteger> getSet() {
		return set;
	}

}
