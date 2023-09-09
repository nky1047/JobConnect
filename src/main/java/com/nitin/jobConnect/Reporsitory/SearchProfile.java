package com.nitin.jobConnect.Reporsitory;

import java.util.List;

import com.nitin.jobConnect.POJOs.Profiles;

public interface SearchProfile {
	List<Profiles> searchProfileByText(String text);
}
