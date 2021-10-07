package com.travelpackage.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Task {
	@Id
	@GeneratedValue(generator = "task_id", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "task_id", sequenceName = "task_seq",initialValue = 1,allocationSize = 1)
	private Integer taskId;
	private String taskName;
	private String category;
	private String owner;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private double duration;
	@Enumerated(EnumType.STRING)
	@Column(length = 8)
	private Priority priority;
	@Enumerated(EnumType.STRING)
	@Column(length = 8)
	private Status status;
	
	@ManyToOne
	@JoinColumn(name = "agent_id")
	private TravelAgent travelAgent;
	
	@ManyToOne
	@JoinColumn(name = "package_id")
	private TravelPackage travelPackage;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "task_id")
	private Set<Worker> workers;

}

