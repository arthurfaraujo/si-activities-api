package com.si.activities.server.dtos;

import java.util.List;

public record Error(List<String> errors, int status) {
	
}
