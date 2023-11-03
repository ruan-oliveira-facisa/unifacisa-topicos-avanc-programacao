package com.facisa.toavpr.aula.myApp.projeto09.tapProjeto09.scheduling;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.facisa.toavpr.aula.myApp.projeto09.tapProjeto09.service.ScheduledService;

@Component
@ConditionalOnProperty(name = "scheduler.enabled", matchIfMissing = true)
public class ScheduledTasks {
	
	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Autowired
	private ScheduledService scheduledService;
	
//	@Scheduled(fixedRate = 5000)
//	public void reportCurrentTime() {
//		String retorno = scheduledService.getTexto();
//		log.info(retorno+ " A hota agora é  {}", dateFormat.format(new Date()));
//	}
	
//	 @Scheduled(fixedDelayString = "${interval}")
//	  public void reportCurrentTime2() {
//	    
//			log.info(" A hota agora é  {}", dateFormat.format(new Date()));
//	  }
	 
	 @Scheduled(cron = "${interval-in-cron}")
	  public void reportCurrentTime3() {
	    
			log.info(" A hota agora é  {}", dateFormat.format(new Date()));
	  }

}
