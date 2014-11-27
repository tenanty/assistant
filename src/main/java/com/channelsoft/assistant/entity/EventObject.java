package com.channelsoft.assistant.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * event must be an Event Object with a title and start at the very least.
 * @author tenanty
 *
 */
@Entity
@Table(name="eventObject")
public class EventObject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long eventId;
	
	private String id;
	@Column(name="title",nullable=false)
	private String title;
	private Boolean allDay;
	@Column(nullable=false)
	private Date start;
	private Date end;
	private String url;
	private String className;
	
	private Boolean editable;
	private Boolean startEditable;
	private Boolean durationEditable;
	private String rendering;
	private Boolean overlap;
	private String eventConstraint;
	private String source;
	private String color;
	private String backgroundColor;
	private String borderColor;
	private String textColor;
	
	public EventObject() {
		super();
	}
	
	public EventObject(Long eventId, String id, String title, Boolean allDay,
			Date start, Date end, String url, String className,
			Boolean editable, Boolean startEditable, Boolean durationEditable,
			String rendering, Boolean overlap, String constraint,
			String source, String color, String backgroundColor,
			String borderColor, String textColor) {
		super();
		this.eventId = eventId;
		this.id = id;
		this.title = title;
		this.allDay = allDay;
		this.start = start;
		this.end = end;
		this.url = url;
		this.className = className;
		this.editable = editable;
		this.startEditable = startEditable;
		this.durationEditable = durationEditable;
		this.rendering = rendering;
		this.overlap = overlap;
		this.eventConstraint = constraint;
		this.source = source;
		this.color = color;
		this.backgroundColor = backgroundColor;
		this.borderColor = borderColor;
		this.textColor = textColor;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Boolean getAllDay() {
		return allDay;
	}
	public void setAllDay(Boolean allDay) {
		this.allDay = allDay;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public Boolean getEditable() {
		return editable;
	}
	public void setEditable(Boolean editable) {
		this.editable = editable;
	}
	public Boolean getStartEditable() {
		return startEditable;
	}
	public void setStartEditable(Boolean startEditable) {
		this.startEditable = startEditable;
	}
	public Boolean getDurationEditable() {
		return durationEditable;
	}
	public void setDurationEditable(Boolean durationEditable) {
		this.durationEditable = durationEditable;
	}
	public String getRendering() {
		return rendering;
	}
	public void setRendering(String rendering) {
		this.rendering = rendering;
	}
	public Boolean getOverlap() {
		return overlap;
	}
	public void setOverlap(Boolean overlap) {
		this.overlap = overlap;
	}
	public String getEventConstraint() {
		return eventConstraint;
	}
	public void setEventConstraint(String constraint) {
		this.eventConstraint = constraint;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getBackgroundColor() {
		return backgroundColor;
	}
	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	public String getBorderColor() {
		return borderColor;
	}
	public void setBorderColor(String borderColor) {
		this.borderColor = borderColor;
	}
	public String getTextColor() {
		return textColor;
	}
	public void setTextColor(String textColor) {
		this.textColor = textColor;
	}
	public Long getEventId() {
		return eventId;
	}
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	
}
