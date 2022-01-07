package dev.fringe.model;

import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Entity
@Table(name = "TBL_USERS")
@Data
@TableName(value = "TBL_USERS")
public class User {

	@Id
//	@GeneratedValue
	@Column(name = "USER_ID")
	 @TableField(value = "USER_ID")
	@TableId(value = "USER_ID")
	private Long id;

	@Column(name = "USER_NAME")
	@TableField(value = "USER_NAME")
	@Size(max = 20, min = 3, message = "{user.name.invalid}")
	@NotEmpty(message = "Please Enter your name")
	private String name;

	@Column(name = "USER_EMAIL", unique = true)
	 @TableField(value = "USER_EMAIL")
	@Email(message = "{user.email.invalid}")
	@NotEmpty(message = "Please Enter your email")
	private String email;

	public User() {
		id = new Random().nextLong();
	}
	
}
