package com.delivery.rocket.checkoffice.action;

import org.springframework.web.servlet.ModelAndView;

import com.delivery.rocket.checkoffice.dto.OfficeDto;

public interface CheckAction {
  public ModelAndView execute(OfficeDto officeDto);
}
