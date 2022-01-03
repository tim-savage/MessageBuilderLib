package com.winterhavenmc.util.messagebuilder;

import org.bukkit.command.CommandSender;

import java.util.List;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("unused")
public interface MessageBuilder<MessageId extends Enum<MessageId>, Macro extends Enum<Macro>> {

	/**
	 * Initiate a message
	 *
	 * @param recipient the command sender to whom the message will be sent
	 * @param messageId the message identifier
	 * @return Message - an initialized message object
	 */
	Message<MessageId, Macro> build(CommandSender recipient, MessageId messageId);

	/**
	 * Check if a message is enabled in the configuration file
	 *
	 * @param messageId the message identifier
	 * @return true if message is enabled, false if not
	 */
	boolean isEnabled(MessageId messageId);

	/**
	 * Get the configured repeat delay for a message
	 *
	 * @param messageId the message identifier
	 * @return long - the message repeat delay (in seconds)
	 */
	long getRepeatDelay(MessageId messageId);

	/**
	 * get message text from language file
	 *
	 * @param messageId the message identifier
	 * @return String message text, or empty string if no message string found
	 */
	String getMessage(MessageId messageId);

	/**
	 * Get item name from language specific messages file, with translated color codes
	 *
	 * @return the formatted item name from language file, or empty string if key not found
	 */
	String getItemName();

	/**
	 * Get configured plural item name from language file
	 *
	 * @return the formatted item plural name from language file, or empty string if key not found
	 */
	String getItemNamePlural();

	/**
	 * Get configured inventory item name from language file
	 *
	 * @return the formatted inventory display name of an item, or empty string if key not found
	 */
	String getInventoryItemName();

	/**
	 * Get item lore from language specific messages file, with translated color codes
	 *
	 * @return List of strings, one string for each line of lore, or empty list if key not found
	 */
	List<String> getItemLore();

	/**
	 * Get spawn display name from language file
	 *
	 * @return the formatted display name for the world spawn, or empty string if key not found
	 */
	String getSpawnDisplayName();

	/**
	 * Get home display name from language file
	 *
	 * @return the formatted display name for home, or empty string if key not found
	 */
	String getHomeDisplayName();

	/**
	 * Format the time string with days, hours, minutes and seconds as necessary
	 *
	 * @param duration a time duration in milliseconds
	 * @return formatted time string
	 */
	String getTimeString(long duration);

	/**
	 * Format the time string with days, hours, minutes and seconds as necessary, to the granularity passed
	 *
	 * @param duration a time duration in milliseconds
	 * @param timeUnit the time granularity to display (days | hours | minutes | seconds)
	 * @return formatted time string
	 * @throws NullPointerException if parameter is null
	 */
	String getTimeString(long duration, TimeUnit timeUnit);

	/**
	 * Reload messages from configured language file
	 */
	void reload();
}
