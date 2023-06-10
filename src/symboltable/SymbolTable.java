package symboltable;

import java.util.*;
import ast.definitions.Definition;

public class SymbolTable {
	
	private int scope=0;

	/**
	 * Each Map is a new scope
	 */
	private List<Map<String,Definition>> table;
	public SymbolTable()  {
		table = new ArrayList<Map<String, Definition>>();
		table.add(new HashMap<String, Definition>());
	}

	/**
	 * Opens scope by incrementing in one the scope attribute.
	 */
	public void set() {
		scope += 1;
		Map<String, Definition> newScope = new HashMap<String, Definition>();
		table.add(newScope);
	}

	/**
	 * Closes scope by decrementing in one the scope attribute.
	 */
	public void reset() {
		table.remove(scope);
		scope -= 1;
	}

	/**
	 * Inserts the definition in the table. Raises an error if the table has a definition with the same name
	 * in the same scope.
	 * @param definition contains the definition to be added
	 * @return boolean true if the definition was inserted, false if the table already had the definition
	 */
	public boolean insert(Definition definition) {
		definition.setScope(scope);
		if (findInCurrentScope(definition.getName()) != null) // if the table already has this definition in scope
			return false; // return false
		table.get(scope).put(definition.getName(), definition); // add definition to the scope
		return true;
	}

	/**
	 * Returns the definition of the passed id from the most nested scope outwards
	 * @param id contains the id of the definition to find
	 * @return Definition or null if there isn't any with that id
	 */
	public Definition find(String id) {
		int nested = table.size()-1;
		for (int i = nested; i >= 0; i--){
			if (table.get(i).get(id) != null)
				return table.get(i).get(id);
		}
		return null;
	}

	/**
	 * Returns the definition if found in current scope
	 * @param id of the definition to find
	 * @return Definition if found, null if not
	 */
	public Definition findInCurrentScope(String id) {
		return table.get(scope).get(id);
	}
}
