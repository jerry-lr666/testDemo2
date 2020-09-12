package cn.tedu.demo1.rui.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * <p>
 * 
 * </p>
 *
 * @author tedu.cn
 * @since 2020-08-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("message")
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("name")
    @NotBlank(message = "用户名不能为空")
    @Size(min = 4,max = 12,message = "账户必须为4-16个字符")
    private String name;

    @TableField("password")
    @NotBlank(message = "密码不能为空")
    @Size(min = 4,max = 16,message = "密码必须为4-16个字符")
    private String password;


}
