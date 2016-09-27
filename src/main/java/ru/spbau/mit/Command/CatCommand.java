package ru.spbau.mit.Command;

import com.google.common.io.ByteStreams;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Cat command -- gets the input stream to output stream
 * if no args are passed, otherwise copies files to outputstream
 */
class CatCommand extends Command {
    CatCommand(List<Argument> a_args) {
        super(a_args);
    }

    @Override
    public void run() throws IOException {
        if (m_args.size() == 0){
            ByteStreams.copy(getInputStream(), getOutputStream());
        }
        for (Argument arg : m_args){
            // Stupid java can't get path get
            File f = new File(arg.getContents()).getAbsoluteFile();
            Files.copy(f.toPath(), getOutputStream());
            getOutputStream().write("\n".getBytes());
        }

        flush();
    }
}
