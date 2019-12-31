package com.hsq.base_project_mvp.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

import java.util.Stack;

/**
 * 应用程序Activity管理类：用于Activity管理和应用程序退出
 * 
 * @version 1.0
 * @created 2012-3-21
 */
public class AppManager {

	private static Stack<Activity> m_stack_activity;
	private static AppManager m_instance;

	private AppManager() {
	}

	/**
	 * 单一实例
	 */
	public static AppManager getAppManager() {
		if (m_instance == null) {
			m_instance = new AppManager();
		}
		return m_instance;
	}

	/**
	 * 添加Activity到堆栈
	 */
	public void addActivity(Activity activity) {
		if (m_stack_activity == null) {
			m_stack_activity = new Stack<Activity>();
		}
		m_stack_activity.add(activity);
	}

	/**
	 * 获取当前Activity（堆栈中最后一个压入的）
	 */
	public Activity currentActivity() {
		Activity activity = m_stack_activity.lastElement();
		return activity;
	}

	/**
	 * 结束当前Activity（堆栈中最后一个压入的）
	 */
	public void finishActivity() {
		Activity activity = m_stack_activity.lastElement();
		finishActivity(activity);
	}

	/**
	 * 结束指定的Activity
	 */
	public void finishActivity(Activity activity) {
		if (activity != null) {
			m_stack_activity.remove(activity);
			activity.finish();
			activity = null;
		}
	}

	/**
	 * 结束指定类名的Activity
	 */
	public  void finishActivity(Class<?> cls) {
		for (int i = 0; i < m_stack_activity.size(); i++) {
			Activity activity = m_stack_activity.get(i);
			if (activity.getClass().equals(cls)) {
				finishActivity(activity);
			}
		}
//		for (Activity activity : m_stack_activity) {
//			if (activity.getClass().equals(cls)) {
//				finishActivity(activity);
//			}
//		}
	}

	/**
	 * 结束所有Activity
	 */
	public void finishAllActivity() {
		for (int i = 0, size = m_stack_activity.size(); i < size; i++) {
			if (null != m_stack_activity.get(i)) {
				m_stack_activity.get(i).finish();
			}
		}
		m_stack_activity.clear();
	}

	/**
	 * 退出应用程序
	 */
	public void AppExit(Context context) {
		try {
			finishAllActivity();
			ActivityManager activityMgr = (ActivityManager) context
					.getSystemService(Context.ACTIVITY_SERVICE);
			activityMgr.restartPackage(context.getPackageName());
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}