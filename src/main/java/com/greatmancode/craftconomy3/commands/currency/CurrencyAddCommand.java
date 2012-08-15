/*
 * This file is part of Craftconomy3.
 *
 * Copyright (c) 2011-2012, Greatman <http://github.com/greatman/>
 *
 * Craftconomy3 is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Craftconomy3 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Craftconomy3.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.greatmancode.craftconomy3.commands.currency;

import com.greatmancode.craftconomy3.Common;
import com.greatmancode.craftconomy3.commands.CraftconomyCommand;

public class CurrencyAddCommand implements CraftconomyCommand {

	@Override
	public void execute(String sender, String[] args) {
		if (args[0] != null && args[1] != null && args[2] != null && args[3] != null) {
			if (Common.getInstance().getCurrencyManager().getCurrency(args[0]) == null) {
				Common.getInstance().getCurrencyManager().addCurrency(args[0], args[1], args[2], args[3], true);
				Common.getInstance().getServerCaller().sendMessage(sender, "{{DARK_GREEN}}Currency added!");
			} else {
				Common.getInstance().getServerCaller().sendMessage(sender, "{{RED}}This currency already exists!");
			}
			
		}
	}

	@Override
	public boolean permission(String sender) {
		return Common.getInstance().getServerCaller().checkPermission(sender, "craftconomy.currency.add");
	}

	@Override
	public String help() {
		return "/currency add <Name> <Name Plural> <Minor> <Minor Plural> - Add a currency.";
	}

	@Override
	public int maxArgs() {
		return 4;
	}

	@Override
	public int minArgs() {
		return 4;
	}

	@Override
	public boolean playerOnly() {
		return false;
	}

}