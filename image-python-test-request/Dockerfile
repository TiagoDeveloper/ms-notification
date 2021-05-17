FROM python:3

RUN python3 -m venv /opt/venv

COPY requirements.txt ./
RUN /opt/venv/bin/pip install --no-cache-dir -r requirements.txt

COPY ./teste.py .

CMD [ "/opt/venv/bin/python", "./teste.py" ]