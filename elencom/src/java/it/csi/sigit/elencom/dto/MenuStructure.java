package it.csi.sigit.elencom.dto;
import java.util.*;
import flexjson.JSON;

/**
 * contiene la struttura della singola voce di menu dell'applicazione
 * @generated
 */
public class MenuStructure implements java.io.Serializable {

	/**
	 * nome del menu
	 * @generated
	 */
	private String menuName;

	/**
	 * lista dei sottomenu
	 * @generated
	 */
	private List<MenuStructure> submenus = new ArrayList<MenuStructure>();

	/**
	 * @generated
	 */
	private boolean visible;

	/**
	 * @generated
	 */
	private boolean enabled;

	/**
	 * restutuisce il nome della voce di menu
	 * @generated
	 */
	public String getMenuName() {
		return menuName;
	}

	/**
	 * imposta il nome della voce di menu
	 * @param menuName
	 * @generated
	 */
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	@JSON(include = false)
	/**
	 * restituisce la lista dei sottomenu 
	 * @generated
	 */
	public List<MenuStructure> getSubmenus() {
		return submenus;
	}

	/**
	 * il menu e' visibile?
	 * @generated
	 */
	public boolean isVisible() {
		return visible;
	}

	/**
	 * @generated
	 */
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	/**
	 * il menu e' abilitato?
	 * @generated
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @generated
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * costruttore
	 * @generated
	 */
	public MenuStructure() {
	}

	/**
	 * costruttore
	 * @param manuName
	 * @generated
	 */
	public MenuStructure(String menuName) {
		this.menuName = menuName;
	}

	/**
	 * costruttore
	 * @param manuName
	 * @param visible
	 * @param enabled
	 * @param active
	 * @generated
	 */
	public MenuStructure(String menuName, boolean visible, boolean enabled, boolean active) {
		this.menuName = menuName;
		this.visible = visible;
		this.enabled = enabled;
	}

	@JSON(include = false)

	/**
	 * restituisce la lista di tutte le voci di menu nel sottoalbero dei submenu
	 * di questa voce di menu
	 * @generated
	 */
	public List<String> getAllSubMenu() {
		List<String> allSubMenu = new ArrayList<String>();

		return addSubMenu(allSubMenu, getSubmenus());
	}

	@JSON(include = false)

	/**
	 * restituisce il sottomenu a partire dal nodo di nome 'menuName'
	 * @param mn il menu in cui cercare
	 * @param menuName il menu da cercare
	 * @generated
	 */
	public MenuStructure getSubMenu(MenuStructure mn, String menuName) {
		for (MenuStructure menuStructure : mn.getSubmenus()) {
			if (menuStructure.getMenuName().equalsIgnoreCase(menuName)) {
				return menuStructure;
			}
			getSubMenu(menuStructure, menuName);
		}

		return mn;
	}

	@JSON(include = false)

	/**
	 * restituisce la lista piatta dei sottomenu
	 * @param mn il menu in cui cercare
	 * @param menuName il menu da cercare
	 * @generated
	 */
	public List<MenuStructure> getSubMenuFlattenList(MenuStructure mn, String menuName) {
		List<MenuStructure> res = new ArrayList<MenuStructure>();
		res.addAll(mn.getSubmenus());
		for (MenuStructure menuStructure : mn.getSubmenus()) {
			res.addAll(menuStructure.getSubMenuFlattenList(menuStructure, menuStructure.getMenuName()));
		}
		return res;
	}

	private List<String> addSubMenu(List<String> allSubMenu, List<MenuStructure> submenus) {
		for (MenuStructure menuStructure : submenus) {
			allSubMenu.add(menuStructure.getMenuName());
			addSubMenu(allSubMenu, menuStructure.getSubmenus());
		}
		return allSubMenu;
	}
}
