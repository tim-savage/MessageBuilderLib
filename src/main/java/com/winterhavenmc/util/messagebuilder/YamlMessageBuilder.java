package com.winterhavenmc.util.messagebuilder;

import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("unused")
public class YamlMessageBuilder<MessageId extends Enum<MessageId>, Macro extends Enum<Macro>> implements MessageBuilder<MessageId, Macro> {

	LanguageHandler languageHandler;


	/**
	 * Class constructor
	 *
	 * @param plugin reference to plugin main class
	 */
	public YamlMessageBuilder(final JavaPlugin plugin) {
		this.languageHandler = new YamlLanguageHandler(plugin);
	}


	/**
	 * Initiate a message
	 * @param recipient the command sender to whom the message will be sent
	 * @param messageId the message identifier
	 * @return Message - an initialized message object
	 */
	@Override
	public Message<MessageId, Macro> build(final CommandSender recipient, final MessageId messageId) {
		return new Message<>(recipient, messageId, languageHandler);
	}


	/**
	 * Check if a message is enabled in the configuration file
	 * @param messageId the message identifier
	 * @return true if message is enabled, false if not
	 */
	@Override
	public boolean isEnabled(final MessageId messageId) {
		return languageHandler.isEnabled(messageId);
	}


	/**
	 * Get the configured repeat delay for a message
	 * @param messageId the message identifier
	 * @return long - the message repeat delay (in seconds)
	 */
	@Override
	public long getRepeatDelay(final MessageId messageId) {
		return languageHandler.getRepeatDelay(messageId);
	}


	/**
	 * get message text from language file
	 *
	 * @param messageId the message identifier
	 * @return String message text, or empty string if no message string found
	 */
	@Override
	public String getMessage(final MessageId messageId) {
		return languageHandler.getMessage(messageId);
	}


	/**
	 * Get item name from language specific messages file, with translated color codes
	 *
	 * @return the formatted item name from language file, or empty string if key not found
	 */
	@Override
	public String getItemName() {
		return languageHandler.getItemName();
	}


	/**
	 * Get configured plural item name from language file
	 *
	 * @return the formatted item plural name from language file, or empty string if key not found
	 */
	@Override
	public String getItemNamePlural() {
		return languageHandler.getItemNamePlural();
	}


	/**
	 * Get configured inventory item name from language file
	 *
	 * @return the formatted inventory display name of an item, or empty string if key not found
	 */
	@Override
	public String getInventoryItemName() {
		return languageHandler.getInventoryItemName();
	}


	/**
	 * Get item lore from language specific messages file, with translated color codes
	 *
	 * @return List of strings, one string for each line of lore, or empty list if key not found
	 */
	@Override
	public List<String> getItemLore() {
		return languageHandler.getItemLore();
	}


	/**
	 * Get spawn display name from language file
	 *
	 * @return the formatted display name for the world spawn, or empty string if key not found
	 */
	@Override
	public String getSpawnDisplayName() {
		return languageHandler.getSpawnDisplayName();
	}


	/**
	 * Get home display name from language file
	 *
	 * @return the formatted display name for home, or empty string if key not found
	 */
	@Override
	public String getHomeDisplayName() {
		return languageHandler.getHomeDisplayName();
	}


	/**
	 * Format the time string with days, hours, minutes and seconds as necessary
	 *
	 * @param duration a time duration in milliseconds
	 * @return formatted time string
	 */
	@Override
	public String getTimeString(final long duration) {
		return languageHandler.getTimeString(duration);
	}


	/**
	 * Format the time string with days, hours, minutes and seconds as necessary, to the granularity passed
	 *
	 * @param duration a time duration in milliseconds
	 * @param timeUnit the time granularity to display (days | hours | minutes | seconds)
	 * @return formatted time string
	 * @throws NullPointerException if parameter is null
	 */
	@Override
	public String getTimeString(final long duration, TimeUnit timeUnit) {
		return languageHandler.getTimeString(duration, timeUnit);
	}


	/**
	 * Reload messages from configured language file
	 */
	@Override
	public void reload() {
		languageHandler.reload();
	}

}