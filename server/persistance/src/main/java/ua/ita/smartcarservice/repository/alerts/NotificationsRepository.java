package ua.ita.smartcarservice.repository.alerts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ua.ita.smartcarservice.entity.alerts.Notifications;

@Repository
public interface NotificationsRepository extends JpaRepository<Notifications, Long>{

	@Query("SELECT n FROM Notifications n WHERE n.userId = :userId AND "
			+ "n.isVisible = true")
	List<Notifications> getAllNotificationsForUser(@Param ("userId") Long userId);

	@Query("SELECT n FROM Notifications n WHERE n.notificationTime IN "
			+ "(SELECT max(notificationTime) from Notifications) AND "
			+ "n.message LIKE '%:message%' ")
	Notifications findLastNotificationByMessage(@Param ("message") String message);
}
